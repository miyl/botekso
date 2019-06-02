package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.models.Webhook;
import kea.botxo.repositories.ReWebhook;

import java.util.List;

/**
 * The service layer for Webhooks
 */
@Service
public class SeWebhook {

    @Autowired
    ReWebhook reWebhook;

    /**
     * Fetches a specific Webhook given by its ID from the database, via the repository layer
     * @author Andreas, Marcus
     * @param id The Webhook to retrieve
     * @return The requested Webhook
     */
    public Webhook fetch(int id){
        return reWebhook.fetch(id);
    }

    /**
     * Fetches a list of all Webhooks from the database, via the repository layer
     * @author Andreas, Marcus
     * @return The list of all Webhooks
     */
    public List<Webhook> fetchAll(){
        return reWebhook.fetchAll();
    }

    /**
     * Updates a specific Webhook in the database, via the repository layer
     * @author Andreas, Marcus
     * @param webhook The Webhook to update
     * @return True if at least one row was updated, otherwise false
     */
    public boolean update(Webhook webhook){
        return reWebhook.update(webhook);
    }

    /**
     * Deletes a specific Webhook from the database, via the repository layer
     * @author Andreas, Marcus
     * @param id The Webhook to delete
     * @return True if at least one row was deleted, otherwise false
     */
    public boolean delete(int id){
        return reWebhook.delete(id);
    }

    /**
     * Adds a new Webhook to the database, via the repository layer
     * @author Andreas, Marcus
     * @param webhook The Webhook to add
     * @return True if at least one row was added, otherwise false
     */
    public boolean add(Webhook webhook){
        return reWebhook.add(webhook);
    }
}
