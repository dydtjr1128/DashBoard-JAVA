package service;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import lombok.Getter;
import lombok.Setter;
import model.ConnectorDTO;

@Getter
@Setter
public class TestSimpleMQTT{
	
	private final String topic = "test";    
	private final String ip="tcp://172.30.1.34:1883";
	private final String testId="min";
    private MqttClient client;
    private static TestSimpleMQTT instance=null;
    private ConnectorDTO dto=new ConnectorDTO();
     private TestSimpleMQTT(){
     // 
    	System.out.println("testclass start");
    	dto.setDevices(0);
      this.subscribe();
    }
    
     synchronized public static TestSimpleMQTT getInstance() {
    	 if(instance==null) 
    		instance= new TestSimpleMQTT();
    	 
    	 return instance;
     }
   public void subscribe() {
        
      try {
         client = new MqttClient(ip, testId, new MemoryPersistence());      
         
         client.connect();
         
         client.setCallback(new MqttCallback() {
            public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
              System.out.println(arg0+"/"+arg1);
              
              dto.setDevices(Integer.valueOf(arg1.toString()));
               
            }
            
            public void deliveryComplete(IMqttDeliveryToken arg0) {
          
            }
            
            public void connectionLost(Throwable arg0) {
            	
            }
		
         });
    
         
         client.subscribe(topic, 1);
     
         
      }  catch(MqttException me) {
         Debuger.log(TestSimpleMQTT.class.toString(), "reason "+me.getReasonCode());
         Debuger.log(TestSimpleMQTT.class.toString(), "msg "+me.getMessage());
         Debuger.log(TestSimpleMQTT.class.toString(), "loc "+me.getLocalizedMessage());
         Debuger.log(TestSimpleMQTT.class.toString(), "cause "+me.getCause());
         Debuger.log(TestSimpleMQTT.class.toString(), "excep "+me);
         Debuger.printError(me);
        }
   }
   
   public void clientDisConnect(){
      try {
         client.disconnect();
         client.close();
      } catch (MqttException e) {
        /* Debuger.printError(e);*/
      }
   }
	
	
	
	/*ConnectorDTO dto;
	MqttClient sampleClient;
	String topic        = "test";
    String content      = "Message from MqttPublishSample";
    int qos             = 2;
    String broker       = "tcp://10.185.102.55:1883";
    String clientId     = "min";
    MemoryPersistence persistence = new MemoryPersistence();
	public TestSimpleMQTT(ConnectorDTO dto) {	
		try {
			this.dto=dto;
			sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());
           // message.setQos(qos);
            //sampleClient.publish(topic, message);
            //System.out.println("Message published");
           // sampleClient.disconnect();
           // System.out.println("Disconnected");
            //System.exit(0);
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
	}

	
	public void run() {
		try {
			sampleClient.subscribe(topic);
			while(true) {
				System.out.println();
			}
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
}





/*
 * public class SubClient {
   
    //private String topic = "/topic/sample";    
    private MqttClient client;
    
    public SubClient(){
      Debuger.log(SubClient.class.toString(), "시작");      
      subscribe(UnChangableValues.TOPIC);
    }
    
   public void subscribe(String topic) {
        
      try {
         client = new MqttClient(UnChangableValues.MQTT_BROKET_IP, MqttClient.generateClientId(), new MemoryPersistence());      
         // init
         
         client.connect();
         // connect         
         
         client.setCallback(new MqttCallback() {
            public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
               Debuger.log(SubClient.class.toString(), arg0 + ": " + arg1.toString());
               // message가 오면
               
            }
            public void deliveryComplete(IMqttDeliveryToken arg0) {
               // TODO Auto-generated method stub
            }
            public void connectionLost(Throwable arg0) {
               // TODO Auto-generated method stub
            }
         });
         // set callback
         
         client.subscribe(topic, 1);
         // subscribe
         
      }  catch(MqttException me) {
         Debuger.log(SubClient.class.toString(), "reason "+me.getReasonCode());
         Debuger.log(SubClient.class.toString(), "msg "+me.getMessage());
         Debuger.log(SubClient.class.toString(), "loc "+me.getLocalizedMessage());
         Debuger.log(SubClient.class.toString(), "cause "+me.getCause());
         Debuger.log(SubClient.class.toString(), "excep "+me);
         Debuger.printError(me);
        }
   }
   
   public void clientDisConnect(){
      try {
         client.disconnect();
         client.close();
      } catch (MqttException e) {
         Debuger.printError(e);
      }
   }
   
   public static void main(String[] args) {
      new SubClient();
   }
}
*/
