package io.github.csrgxtu.BaiduLocation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

public class MainActivity extends ActionBarActivity {
	private TextView locationInfoTextView = null;  
    private Button startButton = null;  
    private LocationClient locationClient = null;  
    private static final int UPDATE_TIME = 5000;  
    private static int LOCATION_COUTNS = 0;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		locationInfoTextView = (TextView) this.findViewById(R.id.tv_loc_info);
		startButton = (Button) this.findViewById(R.id.btn_start);
		
		locationClient = new LocationClient(this);
		
		//设置定位条件
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);                                //是否打开GPS
		option.setCoorType("bd09ll");                           //设置返回值的坐标类型
//		option.setPriority(LocationClientOption.NetWorkFirst);  //设置定位优先级
		option.setProdName("BaiduLocation");
		option.setScanSpan(UPDATE_TIME);
		locationClient.setLocOption(option);
		
        //注册位置监听器  
        locationClient.registerLocationListener(new BDLocationListener() {  
              
            @Override  
            public void onReceiveLocation(BDLocation location) {  
                // TODO Auto-generated method stub  
                if (location == null) {  
                    return;  
                }  
                StringBuffer sb = new StringBuffer(256);  
                sb.append("Time : ");  
                sb.append(location.getTime());  
                sb.append("\nError code : ");  
                sb.append(location.getLocType());  
                sb.append("\nLatitude : ");  
                sb.append(location.getLatitude());  
                sb.append("\nLontitude : ");  
                sb.append(location.getLongitude());  
                sb.append("\nRadius : ");  
                sb.append(location.getRadius());  
                if (location.getLocType() == BDLocation.TypeGpsLocation){  
                    sb.append("\nSpeed : ");  
                    sb.append(location.getSpeed());  
                    sb.append("\nSatellite : ");  
                    sb.append(location.getSatelliteNumber());  
                } else if (location.getLocType() == BDLocation.TypeNetWorkLocation){  
                    sb.append("\nAddress : ");  
                    sb.append(location.getAddrStr());  
                }  
                LOCATION_COUTNS ++;  
                sb.append("\n检查位置更新次数：");  
                sb.append(String.valueOf(LOCATION_COUTNS));  
                locationInfoTextView.setText(sb.toString());  
            }  
              
            public void onReceivePoi(BDLocation location) {  
            }  
              
        });
        
        startButton.setOnClickListener(new OnClickListener() {  
            
            @Override  
            public void onClick(View v) {  
                if (locationClient == null) {  
                    return;  
                }  
                if (locationClient.isStarted()) {  
                    startButton.setText("Start");  
                    locationClient.stop();  
                }else {  
                    startButton.setText("Stop");  
                    locationClient.start();  
                    /* 
                     *当所设的整数值大于等于1000（ms）时，定位SDK内部使用定时定位模式。 
                     *调用requestLocation( )后，每隔设定的时间，定位SDK就会进行一次定位。 
                     *如果定位SDK根据定位依据发现位置没有发生变化，就不会发起网络请求， 
                     *返回上一次定位的结果；如果发现位置改变，就进行网络请求进行定位，得到新的定位结果。 
                     *定时定位时，调用一次requestLocation，会定时监听到定位结果。 
                     */  
                    locationClient.requestLocation();  
                }  
            }  
        });
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
        if (locationClient != null && locationClient.isStarted()) {  
            locationClient.stop();  
            locationClient = null;  
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
