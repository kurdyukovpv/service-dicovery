package ru.sd.client.service;

public interface ClientService {
    String getDataByRestTemplate();

    String getDataByFeign();
}
