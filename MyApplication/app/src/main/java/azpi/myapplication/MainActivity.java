package azpi.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private PendingIntent pIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button set = (Button) (Button) findViewById(R.id.button1);
        set.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                setAlarm();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setAlarm()
    {
        //Broadcast-a egingo duen intenta konfiguratu
        Intent alarmIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        pIntent = PendingIntent.getBroadcast(MainActivity.this, 0, alarmIntent, 0);
        //Alarma ezarri
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        //Zenbat denboran saltatuko duen alarma
        int interval = 8000;
        //Alarma ezartzeko funtzioa: zer egin ordua iristean, noiztik hasi, zenbat denbora hasieratik, ze intent exekutatu.
        manager.setInexactRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),interval, pIntent);
        Toast.makeText(this, "alarma jarrita", Toast.LENGTH_SHORT).show();
    }
}
