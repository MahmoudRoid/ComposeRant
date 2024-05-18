package parniyan.mahmoudroid.compose.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */
@InstallIn(SingletonComponent::class)
@Module
class NotificationModule {


    //init notification to use app screens
    //these must not included in notification module di
    /* @GeneralNotification
     @Singleton
     @Provides
     fun provideGeneralNotificationManager(@ApplicationContext context: Context): NotificationManager {
         return GeneralNotificationManagerImpl(
             context = context,
             channelId = "parniyan.mahmoud.general.notification",
             channelName = context.getString(R.string.general_notification_channel_name),
             channelDescription = context.getString(R.string.general_notification_channel_description),
             smallIcon = R.drawable.ic_launcher_foreground
         )
     }*/


}