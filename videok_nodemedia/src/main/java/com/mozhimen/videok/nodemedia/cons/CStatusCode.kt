package com.mozhimen.videok.nodemedia.cons

/**
 * @ClassName CStatusCode
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/10/27 17:21
 * @Version 1.0
 */
/**
 * 			case 1000:
 * 				// Toast.makeText(LivePlayerDemoActivity.this, "正在连接视频",
 * 				// Toast.LENGTH_SHORT).show();
 * 				break;
 * 			case 1001:
 * 				// Toast.makeText(LivePlayerDemoActivity.this, "视频连接成功",
 * 				// Toast.LENGTH_SHORT).show();
 * 				break;
 * 			case 1002:
 * 				// Toast.makeText(LivePlayerDemoActivity.this, "视频连接失败",
 * 				// Toast.LENGTH_SHORT).show();
 * 				break;
 * 			case 1004:
 * 				Toast.makeText(LivePlayerDemoActivity.this, "视频播放结束", Toast.LENGTH_SHORT).show();
 * 				break;
 * 			case 1005:
 * 				// Toast.makeText(LivePlayerDemoActivity.this, "网络异常,播放中断",
 * 				// Toast.LENGTH_SHORT).show();
 * 				break;
 * 			case 1006:
 * 				// Toast.makeText(LivePlayerDemoActivity.this, "视频数据未找到",
 * 				// Toast.LENGTH_SHORT).show();
 * 				break;
 * 			case 1007:
 * 				// Toast.makeText(LivePlayerDemoActivity.this, "音频数据未找到",
 * 				// Toast.LENGTH_SHORT).show();
 * 				break;
 * 			case 1008:
 * 				// Toast.makeText(LivePlayerDemoActivity.this, "无法打开视频解码器",
 * 				// Toast.LENGTH_SHORT).show();
 * 				break;
 * 			case 1009:
 * 				// Toast.makeText(LivePlayerDemoActivity.this, "无法打开音频解码器",
 * 				// Toast.LENGTH_SHORT).show();
 * 				break;
 * 			case 1100:
 * 				System.out.println("NetStream.Buffer.Empty");
 * 				break;
 * 			case 1102:
 * 				System.out.println("NetStream.Buffer.Full");
 * 				break;
 * 			case 1103:
 * 				System.out.println("Stream EOF");
 * 				break;
 * 			case 1104:
 * 				/**
 * 				 * 得到 解码后得到的视频高宽值,可用于重绘surfaceview的大小比例 格式为:{width}x{height}
 * 				 * 本例使用LinearLayout内嵌SurfaceView
 * 				 * LinearLayout的大小为最大高宽,SurfaceView在内部等比缩放,画面不失真
 * 				 * 等比缩放使用在不确定视频源高宽比例的场景,用上层LinearLayout限定了最大高宽
 * 				 */
 * 				String[] info = msg.getData().getString("msg").split("x");
 * 				srcWidth = Integer.valueOf(info[0]);
 * 				srcHeight = Integer.valueOf(info[1]);
 * 				doVideoFix();
 * 				break;
 * 			default:
 * 				break;
 * 			}
 */
fun Int.intStatusCode2strStatus():String? =
    CStatusCode.intStatusCode2strStatus(this)

object CStatusCode {
    const val CONNECTING = 1000
    const val CONNECT_SUCCESS = 1001
    const val CONNECT_FAIL = 1002
    const val CONNECT_RECONN = 1003
    const val PLAY_FINISH = 1004
    const val PLAY_FAIL = 1005
    const val VIDEO_UNAVAILABLE = 1006
    const val AUDIO_UNAVAILABLE = 1007
    const val VIDEO_DECODE_FAIL = 1008
    const val AUDIO_DECODE_FAIL = 1009
    const val BUFFER_EMPTY = 1100
    const val BUFFER_FULL = 1102
    const val STREAM_EOF = 1103
    const val GET_SIZE = 1104

    @JvmStatic
    fun intStatusCode2strStatus(statusCode: Int): String? =
        when (statusCode) {
            CONNECTING->"正在连接视频"
            CONNECT_SUCCESS->"视频连接成功"
            CONNECT_FAIL->"视频连接失败"
            CONNECT_RECONN->"视频连接重试"
            PLAY_FINISH->"视频播放结束"
            PLAY_FAIL->"网络异常,播放中断"
            VIDEO_UNAVAILABLE->"视频数据未找到"
            AUDIO_UNAVAILABLE->"音频数据未找到"
            VIDEO_DECODE_FAIL->"无法打开视频解码器"
            AUDIO_DECODE_FAIL->"无法打开音频解码器"
            BUFFER_EMPTY->"NetStream.Buffer.Empty"
            BUFFER_FULL->"NetStream.Buffer.Full"
            STREAM_EOF->"Stream EOF"
            GET_SIZE->"得到解码后视频高宽值"
            else -> null
        }
}