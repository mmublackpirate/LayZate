// Generated code from Butter Knife. Do not modify!
package com.epicmyanmar.layzate;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class FlightListFragment$ListViewOnItemclickListener$$ViewInjector {
  public static void inject(Finder finder, final com.epicmyanmar.layzate.FlightListFragment.ListViewOnItemclickListener target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230730, "field 'tv_status'");
    target.tv_status = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131230727, "field 'tvCarriername'");
    target.tvCarriername = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131230728, "field 'tvOrigin_Destination'");
    target.tvOrigin_Destination = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131230729, "field 'tv_Arrival_Departure_time'");
    target.tv_Arrival_Departure_time = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131230726, "field 'tvFlightname'");
    target.tvFlightname = (android.widget.TextView) view;
  }

  public static void reset(com.epicmyanmar.layzate.FlightListFragment.ListViewOnItemclickListener target) {
    target.tv_status = null;
    target.tvCarriername = null;
    target.tvOrigin_Destination = null;
    target.tv_Arrival_Departure_time = null;
    target.tvFlightname = null;
  }
}
