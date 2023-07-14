package com.mozhimen.videok_rtsp

import android.os.Bundle
import cn.nodemedia.NodePlayer
import com.mozhimen.basick.elemk.androidx.appcompat.bases.BaseActivityVB
import com.mozhimen.uicorek.adaptk.systembar.AdaptKSystemBar
import com.mozhimen.uicorek.adaptk.systembar.cons.CProperty
import com.mozhimen.uicorek.adaptk.systembar.initAdaptKSystemBar
import com.mozhimen.videok_rtsp.databinding.ActivityMainBinding

class RTSPMainActivity : BaseActivityVB<ActivityMainBinding>() {
    private val _rtspUrl = "rtsp://admin:shangqu2020@192.168.2.26:554/cam/realmonitor?channel=1&subtype=0"
    private var _nodePlayer: NodePlayer? = null

    override fun initFlag() {
        initAdaptKSystemBar(CProperty.IMMERSED_HARD_STICKY)
    }

    override fun initData(savedInstanceState: Bundle?) {
        _nodePlayer = NodePlayer(this)        //设置播放视图
        _nodePlayer!!.apply {
            setPlayerView(vb.mainRtspView)        //设置RTSP流使用的传输协议,支持的模式有:
            setRtspTransport(NodePlayer.RTSP_TRANSPORT_TCP)
            setInputUrl(_rtspUrl)        //设置视频是否开启
            setVideoEnable(true)
            setBufferTime(500)
            setMaxBufferTime(1000)
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