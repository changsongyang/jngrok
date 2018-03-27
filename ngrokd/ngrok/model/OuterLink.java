package ngrok.model;

import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OuterLink
{
	private String url;
	private Socket outerSocket;
	private Socket controlSocket;
	private BlockingQueue<Socket> proxySocketQueue = new LinkedBlockingQueue<Socket>();

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public Socket getOuterSocket()
	{
		return outerSocket;
	}

	public void setOuterSocket(Socket outerSocket)
	{
		this.outerSocket = outerSocket;
	}

	public Socket getControlSocket()
	{
		return controlSocket;
	}

	public void setControlSocket(Socket controlSocket)
	{
		this.controlSocket = controlSocket;
	}

	public Socket takeProxySocket()
	{
		try
		{
			return proxySocketQueue.take();
		}
		catch(InterruptedException e)
		{
		}
		return null;
	}

	public void putProxySocket(Socket proxySocket)
	{
		try
		{
			proxySocketQueue.put(proxySocket);
		}
		catch(InterruptedException e)
		{
		}
	}
}
