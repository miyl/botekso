package kea.botxo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.Model.Webhook;
import kea.botxo.Repository.ReWebhook;

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
    public boolean add(Webhook webhook){
        if(reWebhook.add(webhook)){
            return true;
        }
        return false;
    }


}
