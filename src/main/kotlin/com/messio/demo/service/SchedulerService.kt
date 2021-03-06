package com.messio.demo.service

import com.messio.demo.BaseEvent
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import java.time.LocalTime
import java.util.*

@Service
class SchedulerService @Autowired constructor(val publisher: ApplicationEventPublisher) {
    private val logger = LoggerFactory.getLogger(SchedulerService::class.java)
    private val events: SortedMap<LocalTime, MutableList<BaseEvent>> = TreeMap()

    fun enter(event: BaseEvent) {
        events.getOrPut(event.instant, { ArrayList() }).add(event)
    }

    fun run(blocking: Boolean = true){
        events.values.forEach { it.forEach { e -> publisher.publishEvent(e) } }
    }
}