package com.example.cs56102020falljavakepan.controllers;
import com.example.cs56102020falljavakepan.models.Widget;
import com.example.cs56102020falljavakepan.services.WidgetService;
import org.springframework.web.bind.annotation.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class WidgetController {
    WidgetService service = new WidgetService();

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets(){
        return service.findAllWidgets();
    }

    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(
            @PathVariable("wid") String widgetId){
          return service.findWidgetById(widgetId);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("tid") String tid){
        return service.findWidgetsForTopic(tid);
    }

    @PostMapping("/api/widgets")
    public Widget createWidget(
            @RequestBody Widget widget) {
        return service.createWidget(widget);
    }

    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(
            @PathVariable("wid") String wid,
            @RequestBody Widget newWidget) {
        return service.updateWidget(wid,newWidget);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public int deleteWidget(
            @PathVariable("wid") String wid){
        return service.deleteWidget(wid);
    }

}
