package suthan.service.text;
import android.app.PendingIntent;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class BattleWidgetProvider extends AppWidgetProvider {
	 public void setWidgetEvent(Context context) {
		 Intent intent = new Intent(context, StepCount.class);
		 PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
		 RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
	      views.setOnClickPendingIntent(R.id.button, pendingIntent);
	 }
}
