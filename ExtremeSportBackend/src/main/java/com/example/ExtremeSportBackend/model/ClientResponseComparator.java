package com.example.ExtremeSportBackend.model;

import java.util.Comparator;

public class ClientResponseComparator implements Comparator<ClientResponse> {
    @Override
    public int compare(ClientResponse o1, ClientResponse o2) {
        return (int)(o1.getEstimatedCost() - o2.getEstimatedCost());
    }
}
