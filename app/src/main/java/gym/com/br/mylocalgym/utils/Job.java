package gym.com.br.mylocalgym.utils;

import android.os.Handler;
import android.os.Message;

import gym.com.br.mylocalgym.services.CheckinService;

/**
 * Created by Matheus on 23/10/2016.
 */

public class Job implements Runnable{

    private CheckinService service;

    private Handler handler;
    private Integer checkinId;
    private Integer clienteId;

    public Job(Handler handler, Integer clienteId, Integer checkinId) {
        this.clienteId = clienteId;
        this.checkinId = checkinId;
        this.handler = handler;
    }

    Thread t;

    @Override
    public void run() {

        boolean validado = false;

        try {
            while(!validado){

                Thread.sleep(10 * 1000);

                validado = verificarSolicitacao(clienteId, checkinId);

            }

            Message message = new Message();
            message.what = 1;
            message.obj = "Finalizando...";
            handler.sendMessage(message);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private boolean verificarSolicitacao(Integer clienteId, Integer checkinId) {

        this.service = new CheckinService();

        boolean validado = this.service.verificarSolicitacao(clienteId, checkinId);

        if (validado) {
            return true;
        }
        return false;

    }

}
