package com.dubu.controller;


import com.dubu.converter.GuestBookConverter;
import com.dubu.model.Guest;
import com.dubu.utiles.MessageUtil;
import org.primefaces.event.RowEditEvent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * User: Administrator
 * Date: 13. 4. 4
 * Time: ?? 5:50
 */
@ManagedBean
@ViewScoped
public class GuestTableController implements Serializable {

    private List<Guest> guests;
    private Guest selectedGuest;
    private Guest[] selectedGuests;
    private List<Guest> selectedGuestsList;
    private SelectItem[] guestNamesOptions;

    public GuestTableController() {
        guests = new ArrayList<Guest>(GuestBookConverter.guests.values());
    }

    public String[] getGuestNames() {
        return GuestBookConverter.guests.keySet().toArray(new String[0]);
    }

    public SelectItem[] getGuestNamesAsOptions() {
        guestNamesOptions = createFilterOptions(GuestBookConverter.guests.keySet().toArray(new String[0]));
        return guestNamesOptions;
    }

    private SelectItem[] createFilterOptions(String[] data) {
        SelectItem[] options = new SelectItem[data.length + 1];

        options[0] = new SelectItem("", "Select");
        for(int i = 0; i < data.length; i++) {
            options[i + 1] = new SelectItem(data[i], data[i]);
        }

        return options;
    }

    public void onEdit(RowEditEvent event) {
        MessageUtil.addInfoMessage("guest.edit", ((Guest) event.getObject()).getName());
    }

    public void onCancel(RowEditEvent event) {
        MessageUtil.addInfoMessage("guest.edit.cancelled", ((Guest) event.getObject()).getName());
    }

    public Guest getSelectedGuest() {
        return selectedGuest;
    }

    public void setSelectedGuest(Guest selectedGuest) {
        this.selectedGuest = selectedGuest;
    }

    public Guest[] getSelectedGuests() {
        return selectedGuests;
    }

    public void setSelectedGuests(Guest[] selectedGuests) {
        this.selectedGuests = selectedGuests;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public List<Guest> getSelectedGuestsList() {
        return selectedGuestsList;
    }

    public void setSelectedGuestsList(List<Guest> selectedGuestsList) {
        this.selectedGuestsList = selectedGuestsList;
    }



}
