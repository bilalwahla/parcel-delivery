package com.df.parcel.delivery.consumer;

import com.df.parcel.delivery.model.Parcel;
import com.df.parcel.delivery.queue.ParcelQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Delivers the parcels in the queue.
 *
 * @author bilalwahla
 */
@Service
public class ParcelDelivery {
  private static final Logger log = LoggerFactory.getLogger(ParcelDelivery.class);

  @Autowired
  private ParcelQueue parcelQueue;

  @Scheduled(fixedDelay = 1000, initialDelay = 1000)
  public void deliverAParcel() {
    Parcel parcel = parcelQueue.consumeParcel();

    if (parcel != null) {
      log.debug("Delivering " + parcel + "...");
      // Do whatever needs doing with the parcel info once delivered
      log.debug("Delivered " + parcel + ".");
    }
    else log.debug("No parcels to deliver at the moment.");


  }
}
