package DAO;

import BancoDeDados.DAO;
import static com.google.protobuf.TextFormat.print;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author William Tanaka
 */
public class RelatorioDAO {

    public static final String pasta_relatorios = System.getProperty("user.dir") + "/src/main/java/Relatórios/";
    public static final String pasta_relatorios_teste = System.getProperty("user.dir") + "/src/main/java/Relatórios/RelatorioTreino.jasper";

    JasperPrint impressao;

    public static final File file_relatorio_medidas_fonte_evolucao = new File(pasta_relatorios, "EvolucaoCorporal.jrxml");
    public static final File file_relatorio_medidas_compilado_evolucao = new File(pasta_relatorios, "EvolucaoCorporal.jasper");
    public static final File file_relatorio_medidas_fonte_treino = new File(pasta_relatorios, "RelatorioTreino.jrxml");
    public static final File file_relatorio_medidas_compilado_treino = new File(pasta_relatorios, "RelatorioTreino.jasper");
    

    private Connection connection = null;
    private static final String path = System.getProperty("user.dir");
    private static final File config_file = new File(path + "/src/main/java/BancoDeDados/ConfiguracaoDAO.properties");
    public boolean criaConexao() {
        try {
            DAO.init(config_file);
            connection = DAO.getConnection();
            connection.setAutoCommit(false);//configuracao necessaria para confirmacao ou nao de alteracoes no banco de dados.
            return true;
        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
        }
        return false;
    }
       
   public boolean relatorioEvolucaoCorporal(boolean view, Map parametro) {
        JasperPrint impressao;


        try {
            FileInputStream arquivo = new FileInputStream(file_relatorio_medidas_fonte_evolucao);
            JasperReport relatorio = JasperCompileManager.compileReport(arquivo);
            impressao = JasperFillManager.fillReport(relatorio,parametro,connection);

            if (view) {
                JasperViewer.viewReport(impressao, false);
                return true;
            }
        } catch (JRException | FileNotFoundException erro) {
            System.err.println("Não foi possível exportar o relatório.\n\n" + erro);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
   
   public boolean relatorioTreino(boolean view, Map parametro) {;
        JasperPrint impressao;


        try {
            FileInputStream arquivo = new FileInputStream(file_relatorio_medidas_fonte_treino);
            JasperReport relatorio = JasperCompileManager.compileReport(arquivo);
            impressao = JasperFillManager.fillReport(relatorio,parametro,connection);


            if (view) {
                JasperViewer.viewReport(impressao, false);
            }
            return true;
        } catch (JRException | FileNotFoundException erro) {
            System.err.println("Não foi possível exportar o relatório.\n\n" + erro);
            
        } catch (IOException ex) {
            Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }

    public boolean enviarEmail(Map parametro) {
        Properties props = new Properties();

        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session;
        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("Email@email.com", "Senha");
            }
        });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {
            byte[] bytes = null;
            JasperReport jasper = (JasperReport) JRLoader.loadObjectFromFile(pasta_relatorios_teste);//carrega o arquivo jasper direto da pasta utilizando o .jasper
            bytes = JasperRunManager.runReportToPdf(jasper, parametro, connection);//gera os byrtes do relatorio
            File arq = new File(path + "\\src\\main\\java\\Relatórios", "relatorio.pdf");//gera um arquivo na pasta relatorios
            if (arq.exists()) {//confere se o arquivo ja existe
                arq.delete();
            }
            FileOutputStream fos = new FileOutputStream(arq);//abre o arquivo para escrita
            fos.write(bytes);//escreve os bytes do relatorio dentro do arquivo em pdf
            fos.flush();//
            fos.close();//fecha a escrita do arquivo
            String local = path+"\\src\\main\\java\\Relatórios\\relatorio.pdf";

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("lucasmartinstanaka@alunos.utfpr.edu.br"));
            //Remetente

            Address[] toUser = InternetAddress.parse("ramoncrivelari@alunos.utfpr.edu.br");

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Relatório Oi2Fit");//Assunto

            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setText("Relatório das Medidas");
            MimeBodyPart mbp2 = new MimeBodyPart();
            FileDataSource fds = new FileDataSource(arq);//carrega o arquivo
            mbp2.setDataHandler(new DataHandler(fds));//passa o arquivo para dentro do email
            mbp2.setFileName(fds.getName());//seta o nome do arquivo
            Multipart mp = new MimeMultipart();//junta o texto do arquivo
            mp.addBodyPart(mbp1);
            mp.addBodyPart(mbp2);
            message.setContent(mp);//coloca os 2 juntos
            message.setSentDate(new Date());//

            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);

            System.out.println("Feito!!!");
            return true;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (JRException error) {

        } catch (FileNotFoundException ex) {
            Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}