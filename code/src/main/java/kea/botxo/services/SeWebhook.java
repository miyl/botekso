package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.models.Webhook;
import kea.botxo.repositories.ReWebhook;

import java.util.List;

/**
 *
 */
@Service
public class SeWebhook {

    @Autowired
    ReWebhook reWebhook;

    /**
     *
     * @param id
     * @return
     */
    public Webhook fetch(int id){
        return reWebhook.fetch(id);
    }

    /**
     *
     * @return
     */
    public List<Webhook> fetchAll(){
        return reWebhook.fetchAll();
    }

    /**
     *
     * @param webhook
     * @return
     */
    public boolean update(Webhook webhook){
        if(reWebhook.update(webhook)){
            return true;
        }
        return false;
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean delete(int id){
        return reWebhook.delete(id);
    }

    /**
     *
     * @param webhook
     * @return
     */
    public boolean add(Webhook webhook){
        return reWebhook.add(webhook);
    }
}
