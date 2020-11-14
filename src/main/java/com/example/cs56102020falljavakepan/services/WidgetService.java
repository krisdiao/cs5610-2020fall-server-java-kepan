package com.example.cs56102020falljavakepan.services;

import com.example.cs56102020falljavakepan.models.Widget;
import com.example.cs56102020falljavakepan.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository widgetRepository;

    public List<Widget> findAllWidgets(){
        return (List<Widget>) widgetRepository.findAll();
    }

    public Widget findWidgetById(Integer widgetId){
        return widgetRepository.findById(widgetId).get();
    }

    public List<Widget> findWidgetsForTopic(String tid){
        return widgetRepository.findWidgetsForTopic(tid);
    }


    public Widget createWidget(Widget widget){
        return widgetRepository.save(widget);
    }

    public Widget updateWidget(Integer widgetId, Widget newWidget) {
        Optional widgetO = widgetRepository.findById(widgetId);
        if(widgetO.isPresent()) {
            Widget widget = (Widget) widgetO.get();
            widget.setName(newWidget.getName());
            widget.setType(newWidget.getType());
            return widgetRepository.save(widget);
        } else {
            return null;
        }
    }

    public void deleteWidget(Integer wid) {
        widgetRepository.deleteById(wid);
    }
}
