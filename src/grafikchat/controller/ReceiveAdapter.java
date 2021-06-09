/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafikchat.controller;

import grafikchat.model.ChatModel;
import grafikchat.model.Figur;
import grafikchat.view.View;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;

/**
 *
 * @author Christian
 */
public class ReceiveAdapter implements Subscriber<Figur>
{
  private View view;
  private ChatModel model;
  private Flow.Subscription subscription;
  
  public ReceiveAdapter(View view, ChatModel model)
  {
    this.view = view;
    this.model = model;
  }

  public void onSubscription()
  {
    model.addSubscription(this);
  }
  
  @Override
  public void onSubscribe(Flow.Subscription subscription)
  {
    this.subscription = subscription;
    subscription.request(1);
  }

  @Override
  public void onError(Throwable thrwbl)
  {
  }

  @Override
  public void onComplete()
  {
  }

  @Override
  public void onNext(Figur item)
  {
    view.repaint();
    subscription.request(1);
  }
}


