package gym.com.br.mylocalgym.services;

import gym.com.br.mylocalgym.requesters.CheckinRequester;

/**
 * Created by Matheus on 23/10/2016.
 */

public class CheckinService {

    private CheckinRequester requester;

    public Integer solicitarCheckin(Integer clienteId, Integer academiaId){

        this.requester = new CheckinRequester();
        return this.requester.solicitarCheckin(clienteId, academiaId);
    }

    public boolean verificarSolicitacao(Integer clienteId,  Integer checkinId){

        this.requester = new CheckinRequester();
        return this.requester.verificarSolicitacao(clienteId, checkinId);
    }

}
