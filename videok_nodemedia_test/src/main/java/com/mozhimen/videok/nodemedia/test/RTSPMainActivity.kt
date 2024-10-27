package com.mozhimen.videok.nodemedia.test

import android.os.Bundle
import android.util.Log
import cn.nodemedia.NodePlayer
import com.mozhimen.bindk.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.videok.nodemedia.test.databinding.ActivityMainBinding

class RTSPMainActivity : BaseActivityVDB<ActivityMainBinding>() {
    private val _rtspUrl = "rtsp://admin:shangqu2020@192.168.2.26:554/cam/realmonitor?channel=1&subtype=0"//dahua
    private val _rtspUrl1 = "rtsp://admin:qwer2580@192.168.2.200:554/Streaming/Channels/1"//hik
    private var _nodePlayer: NodePlayer? = null

    override fun initData(savedInstanceState: Bundle?) {
        _nodePlayer = NodePlayer(this)        //设置播放视图
        _nodePlayer!!.apply {
            setPlayerView(vdb.mainRtspView)        //设置RTSP流使用的传输协议,支持的模式有:
            setRtspTransport(NodePlayer.RTSP_TRANSPORT_TCP)
            setInputUrl(_rtspUrl1)        //设置视频是否开启
            setVideoEnable(true)
            setBufferTime(500)
            setMaxBufferTime(1000)
            setNodePlayerDelegate { player, event, msg ->
                Log.d(TAG, "initData: event $event msg $msg")
            }
        }
        super.initData(savedInstanceState)
    }

    override fun onResume() {
        _nodePlayer?.start()
        super.onResume()
    }

    override fun onPause() {
        _nodePlayer?.stop()
        super.onPause()
    }

    override fun onDestroy() {
        _nodePlayer?.release()
        super.onDestroy()
    }
}