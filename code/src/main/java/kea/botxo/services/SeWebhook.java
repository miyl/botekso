package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.models.Webhook;
import kea.botxo.repositories.ReWebhook;

import java.util.List;

@Service
public class SeWebhook {

    @Autowired
    ReWebhook reWebhook;

    public Webhook fetch(int id){
        return reWebhook.fetch(id);
    }

    public List<Webhook> fetchAll(){
        return reWebhook.fetchAll();
    }
    public boolean update(Webhook webhook){
        if(reWebhook.update(webhook)){
            return true;
        }
        return false;
    }
    public boolean delete(int id){
        if(reWebhook.delete(id)){
            return true;
        }
        return false;
    }
    public void add(Webhook webhook){
        reWebhook.add(webhook);
    }


}
