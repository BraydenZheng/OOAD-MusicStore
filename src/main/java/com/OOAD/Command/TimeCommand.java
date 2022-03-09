package com.OOAD.Command;

import com.OOAD.Store;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Brayden
 * @create 3/8/22 4:16 PM
 * @Description
 */
public class TimeCommand extends StoreCommand
{

	public TimeCommand(Store store)
	{
		super(store);
	}

	@Override
	public void excute()
	{
		SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		out(formatter.format(date));
	}
}
