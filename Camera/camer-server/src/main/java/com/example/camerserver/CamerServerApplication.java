package com.example.camerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Stack;

@SpringBootApplication
public class CamerServerApplication {

    public static void main(String[] args) {
//        SpringApplication.run(CamerServerApplication.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(CamerServerApplication.class);
        builder.headless(false).run(args);
        System.out.println("---------------启动成功---------------");

        /**
         * 采用远程监控没专用摄像头作为视频源
         * */
        // 运行，设置视频源和推流地址
        try {
            new ConvertVideoPakcet()
//                    .rtsp("rtsp://admin:123456@192.168.1.115/ch01_sub.264") // ip 厂家提供的的摄像头地址
//                    .rtsp("rtmp://rtmp01open.ys7.com:1935/v3/openlive/G39253040_1_1?expire=1712562011&id=567011230735122432&t=e5dea0b793d1b4e6199c3011e267fac2ad0e4f1d2256bf325a1b27730121b7ff&ev=100") // ip 厂家提供的的摄像头地址
                    .rtsp("rtmp://rtmp01open.ys7.com:1935/v3/openlive/G39253040_1_1?expire=1712562011&id=567011230735122432&t=e5dea0b793d1b4e6199c3011e267fac2ad0e4f1d2256bf325a1b27730121b7ff&ev=100") // ip 厂家提供的的摄像头地址
                    .rtmp("rtmp://127.0.0.1:1935/live/stream2")
                    .start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 采用备抵摄像头当做视频源
         * */
        //设置rtmp服务器推流地址
//        String outputPath = "rtmp://127.0.0.1:1935/live/stream";
//        RecordPush recordPush = new RecordPush();
//        try {
//            recordPush.getRecordPush(outputPath, 25);
////            recordPush.getRecordPush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
