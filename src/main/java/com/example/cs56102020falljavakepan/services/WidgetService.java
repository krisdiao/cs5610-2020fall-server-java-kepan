package com.example.cs56102020falljavakepan.services;

import com.example.cs56102020falljavakepan.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Service
public class WidgetService {

    List<Widget> widgets = new ArrayList<Widget>();
    {
        widgets.add(new Widget("111","Widget 111", "HEADING","topic111"));
        widgets.add(new Widget("112","Widget 112", "LIST","topic112"));
        widgets.add(new Widget("113","Widget 113", "PARAGRAPH","topic113"));
    }

    public List<Widget> findAllWidgets(){
        return widgets;
    }

    public Widget findWidgetById(String widgetId){
        for (Widget w:widgets){
            if(w.getId().equals(widgetId))
                return w;
        }
        return null;
    }

    public List<Widget> findWidgetsForTopic(String tid){
        List <Widget> ws = new ArrayList<Widget>();
        for (Widget w: widgets){
            if (w.getTopicId().equals(tid)){
                ws.add(w);
            }
        }
        return ws;
    }


    public Widget createWidget(String tid, Widget widget){
        widget.setId((new Date()).toString());
        widgets.add(widget);
        return widget;
    }

    public int updateWidget(String wid, Widget newWidget) {
        for(Widget w:widgets){
            if (w.getId().equals(widgets)){
                w.setName(newWidget.getName());
                w.setType(newWidget.getType());
                return 1;
            }
        }
        return 0;
    }

    public int deleteWidget(String wid){
        for(Widget w:widgets){
            if (w.getId().equals(widgets)){
                widgets.remove(w);
                return 1;
            }
        }
        return 0;
    }


}
