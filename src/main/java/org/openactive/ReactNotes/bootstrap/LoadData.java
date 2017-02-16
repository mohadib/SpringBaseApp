package org.openactive.ReactNotes.bootstrap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public abstract class LoadData implements ApplicationListener<ContextRefreshedEvent>
{
  @Value("${app.env:PROD}")
  private String env;

  @Value("${jpa.hbm2ddl.auto}")
  private String hbm2ddl;

  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
  {
    if(!"DEV".equalsIgnoreCase(env)) return;
    if(!"create-drop".equalsIgnoreCase(hbm2ddl)) return;
    if(contextRefreshedEvent.getApplicationContext().getDisplayName().indexOf( "Root" ) == -1) return;
    load();
  }

  public abstract void load();
}
