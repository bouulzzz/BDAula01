package pkg;

public class ExemploThreads {
    public static void main(String[] args) {
        // Criar e iniciar threads secundárias
        MinhaThread thread1 = new MinhaThread("Thread 1 - Mensagem a cada 1 segundo", 1000);
        MinhaThread thread2 = new MinhaThread("Thread 2 - Mensagem a cada 2 segundos", 2000);

        thread1.start();
        thread2.start();

        // Executar operações na thread principal
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread Principal - Iteração " + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Interromper as threads secundárias (opcional)
        thread1.interrupt();
        thread2.interrupt();
    }
}