// **********************************************************************
//
// Generated by the ORBacus IDL to Java Translator
//
// Copyright (c) 2002
// IONA Technologies, Inc.
// Waltham, MA, USA
//
// All Rights Reserved
//
// **********************************************************************

// Version: 4.2.2

package chat;

//
// IDL:ChatService:1.0
//
public class _ChatServiceStub extends org.omg.CORBA.portable.ObjectImpl
                              implements ChatService
{
    private static final String[] _ob_ids_ =
    {
        "IDL:ChatService:1.0",
    };

    public String[]
    _ids()
    {
        return _ob_ids_;
    }

    final public static java.lang.Class _ob_opsClass = ChatServiceOperations.class;

    //
    // IDL:ChatService/getTheDate:1.0
    //
    public String
    getTheDate()
    {
        while(true)
        {
            if(!this._is_local())
            {
                org.omg.CORBA.portable.OutputStream out = null;
                org.omg.CORBA.portable.InputStream in = null;
                try
                {
                    out = _request("getTheDate", true);
                    in = _invoke(out);
                    String _ob_r = in.read_wstring();
                    return _ob_r;
                }
                catch(org.omg.CORBA.portable.RemarshalException _ob_ex)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _ob_aex)
                {
                    final String _ob_id = _ob_aex.getId();
                    in = _ob_aex.getInputStream();

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _ob_id);
                }
                finally
                {
                    _releaseReply(in);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _ob_so = _servant_preinvoke("getTheDate", _ob_opsClass);
                if(_ob_so == null)
                    continue;
                ChatServiceOperations _ob_self = (ChatServiceOperations)_ob_so.servant;
                try
                {
                    return _ob_self.getTheDate();
                }
                finally
                {
                    _servant_postinvoke(_ob_so);
                }
            }
        }
    }

    //
    // IDL:ChatService/newChatRoom:1.0
    //
    public void
    newChatRoom(String _ob_a0)
    {
        while(true)
        {
            if(!this._is_local())
            {
                org.omg.CORBA.portable.OutputStream out = null;
                org.omg.CORBA.portable.InputStream in = null;
                try
                {
                    out = _request("newChatRoom", true);
                    out.write_string(_ob_a0);
                    in = _invoke(out);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _ob_ex)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _ob_aex)
                {
                    final String _ob_id = _ob_aex.getId();
                    in = _ob_aex.getInputStream();

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _ob_id);
                }
                finally
                {
                    _releaseReply(in);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _ob_so = _servant_preinvoke("newChatRoom", _ob_opsClass);
                if(_ob_so == null)
                    continue;
                ChatServiceOperations _ob_self = (ChatServiceOperations)_ob_so.servant;
                try
                {
                    _ob_self.newChatRoom(_ob_a0);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_ob_so);
                }
            }
        }
    }

    //
    // IDL:ChatService/send:1.0
    //
    public void
    send(String _ob_a0,
         String _ob_a1)
    {
        while(true)
        {
            if(!this._is_local())
            {
                org.omg.CORBA.portable.OutputStream out = null;
                org.omg.CORBA.portable.InputStream in = null;
                try
                {
                    out = _request("send", true);
                    out.write_string(_ob_a0);
                    out.write_string(_ob_a1);
                    in = _invoke(out);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _ob_ex)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _ob_aex)
                {
                    final String _ob_id = _ob_aex.getId();
                    in = _ob_aex.getInputStream();

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _ob_id);
                }
                finally
                {
                    _releaseReply(in);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _ob_so = _servant_preinvoke("send", _ob_opsClass);
                if(_ob_so == null)
                    continue;
                ChatServiceOperations _ob_self = (ChatServiceOperations)_ob_so.servant;
                try
                {
                    _ob_self.send(_ob_a0, _ob_a1);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_ob_so);
                }
            }
        }
    }
}
