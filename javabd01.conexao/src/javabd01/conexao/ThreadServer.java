package javabd01.conexao;

import DAO.PessoaDAO;
import beans.Pessoa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.in;
import java.net.Socket;

public class ThreadServer extends Thread {
    private Socket clienteSocket;
    
    public ThreadServer(Socket clienteSocket) {
        this.clienteSocket = clienteSocket;
    }
    
    @Override
    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(clienteSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clienteSocket.getInputStream());

            // para consultar:
            
            // int id = in.readInt();
            // System.out.println("ID recebido: " +id);
            
            //PessoaDAO pdao = new PessoaDAO();
            //Pessoa p = pdao.getPessoa(id);

            //out.writeObject(p);

            // para cadastrar:
            Pessoa p = (Pessoa) in.readObject();
            PessoaDAO pDAO = PessoaDAO();
            pDAO.inserir(p);
            out.writeObject(p);

        // consulta    
        } catch (IOException ex) {
            System.out.println("Erro ao lidar com o cliente");

        //cadastro
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
