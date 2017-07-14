package com.df.parcel.delivery.producer;

import com.df.parcel.delivery.model.Parcel;
import com.df.parcel.delivery.queue.ParcelQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Creates the parcels to be delivered.
 *
 * @author bilalwahla
 */
@Service
public class ParcelProducer {
  @Autowired
  private ParcelQueue parcelQueue;

  private long parcelId = 0;

  @Scheduled(fixedDelay = 500, initialDelay = 1000)
  public void produce() {
    parcelQueue.produceParcel(new Parcel(++parcelId, generateRandomPriority()));
  }

  private int generateRandomPriority() {
    return new Random().nextInt(3) + 1;
  }
}
