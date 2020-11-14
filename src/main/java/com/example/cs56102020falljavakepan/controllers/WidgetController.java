package com.example.cs56102020falljavakepan.controllers;
import com.example.cs56102020falljavakepan.models.Widget;
import com.example.cs56102020falljavakepan.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class WidgetController {

    @Autowired
    WidgetService service ; // = new WidgetService();

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets(){
        return service.findAllWidgets();
    }

    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(
            @PathVariable("wid") Integer widgetId){
          return service.findWidgetById(widgetId);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("tid") String tid){
        return service.findWidgetsForTopic(tid);
    }

    @PostMapping("/api/topics/{topicId}/widgets")
    public Widget createWidget(
            @PathVariable("topicId") String tid,
            @RequestBody Widget widget) {
        widget.setTopicId(tid);
        return service.createWidget(widget);
    }

    @PutMapping("/api/widgets/{wid}")
    public Widget updateWidget(
            @PathVariable("wid") Integer widgetId,
            @RequestBody Widget newWidget) {
        return service.updateWidget(widgetId, newWidget);
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public void deleteWidget(
            @PathVariable("widgetId") Integer wid){
        service.deleteWidget(wid);
    }

}
