/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package parte1;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 *
 * @author ggonzalez 22/4/2024
 */
public interface InterfazAeropuerto extends Remote {
    short getPasajeros() throws RemoteException;
}


