package com.mozhimen.videok.nodemedia.cons

/**
 * @ClassName CStatusCode
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/10/27 17:21
 * @Version 1.0
 */
object CStatusCode {
    const val CONNECTING = 1000
    const val CONNECT_SUCCESS = 1001
    const val CONNECT_FAIL = 1002
    const val PLAY_FINISH = 1004
    const val PLAY_BREAK = 1005
    const val VIDEO_UNAVAILABLE = 1006
    const val AUDIO_UNAVAILABLE = 1007
    const val VIDEO_DECODE_FAIL = 1008
    const val AUDIO_DECODE_FAIL = 1009
    const val BUFFER_EMPTY = 1100
    const val BUFFER_FULL = 1102
    const val STREAM_EOF = 1103
    const val GET_SIZE = 1104
}