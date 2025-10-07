package mx.itson.turnobanco;

import javax.swing.JOptionPane;

public class ED_TurnoBanco {

    public static void showMenu(){
        int option = 0;
        Cola queue = new Cola();
        
        do {
            try {
                option = Integer.parseInt( JOptionPane.showInputDialog(null, ""
                                + "1.- Enqueue(element)\n2.- dequeue()\n"
                                + "3.- Is Empty?\n4.- front()\n"
                                + "5.- size()\n"
                                + "6.- displayQueue()\n"
                                + "7.- Exit\n"
                                + "Input one option:\n") );
                switch (option) {
                    case 1:
                        String numero = JOptionPane.showInputDialog(null, "Ingresa el numero:");
                        String nombre = JOptionPane.showInputDialog(null, "Ingresa el numero:");
                        queue.enqueue(new Turno(numero, nombre));
                        break;
                    case 2:
                        if(!queue.isEmpty()){
                            String elementRemove = queue.dequeue().getNumero();
                            JOptionPane.showMessageDialog(null, "Element removed from the queue: " + elementRemove);
                        }else{
                            JOptionPane.showMessageDialog(null, "The stack is empty");
                        }
                        break;
                    case 3:
                        if(queue.isEmpty()){
                            JOptionPane.showMessageDialog(null, "The queue IS EMPTY");
                        }else{
                            JOptionPane.showMessageDialog(null, "The queue IS NOT EMPTY");
                        }
                        break;
                    case 4:
                        if(!queue.isEmpty()){
                            Turno elementFront = queue.front();
                            JOptionPane.showMessageDialog(null, "The front element is: " + elementFront.getNumero()+"-"+elementFront.getCliente());
                        }else{
                            JOptionPane.showMessageDialog(null, "The queue is empty");
                        }
                        break;
                    case 5:
                        int total = queue.size();
                        JOptionPane.showMessageDialog(null, "The total items in the queue is: " + total);
                        break;
                    case 6:
                        if(queue.isEmpty()){
                            JOptionPane.showMessageDialog(null, "The queue is empty");
                        }else{
                            queue.displayQueue();
                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Program finished.");
                        break;
                }
            }catch(Exception e){
                System.out.println("Error. Ingrese un entero: " + e.getMessage());
            }
        }while(option != 7);
        
    }
}
