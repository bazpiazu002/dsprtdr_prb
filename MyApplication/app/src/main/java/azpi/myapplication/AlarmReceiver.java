package azpi.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Beñat on 07/01/2015.
 */
public class AlarmReceiver extends BroadcastReceiver
{
    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context, "Alarmak jo du", Toast.LENGTH_SHORT).show();
    }
}
