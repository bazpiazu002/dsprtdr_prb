package azpi.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Beñat on 07/01/2015.
 */
public class DeviceBootReceiver extends BroadcastReceiver
{
    public void onReceive(Context context, Intent intent)
    {
        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
        {
            Intent alarmIntent = new Intent(context, AlarmReceiver.class);
            PendingIntent pIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);
            //Alarma ezarri
            AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            //Zenbat denboran saltatuko duen alarma
            int interval = 8000;
            //Alarma ezartzeko funtzioa: zer egin ordua iristean, noiztik hasi, zenbat denbora hasieratik, ze intent exekutatu.
            manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pIntent);
            Toast.makeText(context, "alarma jarrita", Toast.LENGTH_SHORT).show();
        }
    }
}
