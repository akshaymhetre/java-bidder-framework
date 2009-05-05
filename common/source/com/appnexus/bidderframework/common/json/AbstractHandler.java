package com.appnexus.bidderframework.common.json;

import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 11, 2009
 * Time: 3:25:40 PM
 */
public abstract class AbstractHandler<T> implements IJSonHandler<T> {

    private static final Logger LOG = Logger.getLogger(AbstractHandler.class);

    private T dataObject;
    private JSonStAXReader reader;
    private IJSonHandler<?> parentHandler;

    public void setReader(JSonStAXReader reader) {
        this.reader = reader;
    }

    public JSonStAXReader getReader() {
        return reader;
    }

    public void setDataObject(T dataObject) {
        this.dataObject = dataObject;
    }

    public T getDataObject() {
        return dataObject;
    }

    public void endArray(String currentArrayName) {
        if (parentHandler != null) {
            LOG.debug("on endarray=[" + currentArrayName + "] transferring control to=[" + parentHandler + "]");
            getReader().setCurrentHandler(parentHandler);
        }
    }

    public void endObject(String currentObjectName) {
        if (parentHandler != null) {
            LOG.debug("on endobject=[" + currentObjectName + "] transferring control to=[" + parentHandler + "]");
            getReader().setCurrentHandler(parentHandler);
        }
    }

    public void setParentHandler(IJSonHandler<?> parentHandler) {
        this.parentHandler = parentHandler;
    }

    protected void transferControlToNested(IJSonHandler currentHandler, IJSonHandler nestedHandler, Object nestedDataObject) {
        LOG.debug("transferring control to nested from=[" + currentHandler + "] transferring control to=[" + nestedHandler + "]");
        nestedHandler.setParentHandler(currentHandler);
        nestedHandler.setReader(reader);
        //noinspection unchecked
        nestedHandler.setDataObject(nestedDataObject);
        getReader().setCurrentHandler(nestedHandler);
    }
}
