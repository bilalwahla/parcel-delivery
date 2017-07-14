package com.df.parcel.delivery.queue;

import com.df.parcel.delivery.model.Parcel;
import com.df.parcel.delivery.model.ParcelComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.PriorityQueue;

/**
 * Message queue to hold parcel information.
 *
 * @author bilalwahla
 */
@Component
public class ParcelQueue {
  private static final Logger log = LoggerFactory.getLogger(ParcelQueue.class);

  private static PriorityQueue<Parcel> parcels;

  public ParcelQueue() {
    parcels = new PriorityQueue<>(new ParcelComparator());
  }

  public synchronized void produceParcel(Parcel parcel) {
    log.debug("Queuing " + parcel + " for delivery...");
    parcels.offer(parcel);
    log.debug("Queued " + parcel + " for delivery.");
  }

  public synchronized Parcel consumeParcel() {
    return parcels.poll();
  }
}
