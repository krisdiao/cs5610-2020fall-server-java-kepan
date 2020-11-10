package com.example.cs56102020falljavakepan.services;

import com.example.cs56102020falljavakepan.models.Widget;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Service
public class WidgetService {

    List<Widget> widgets = new ArrayList<Widget>();
    { }

    public List<Widget> findAllWidgets(){
        return widgets;
    }

    public Widget findWidgetById(String wid){
        for (Widget w:widgets){
            if(w.getId().equals(wid))
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


    public Widget createWidget(Widget widget){
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
