package com.payegis.config;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class ThreadPoolConfig {

    public static final String EXCEL_EXECUTOR = "EXCEL_EXECUTOR";

    @Bean
    public ExecutorService excelExecutor() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setDaemon(true)
                .setNamePrefix(EXCEL_EXECUTOR.concat("_")).build();
        return new ThreadPoolExecutor(9, 20,
                5, TimeUnit.SECONDS, new ArrayBlockingQueue(200), threadFactory);
    }

}
