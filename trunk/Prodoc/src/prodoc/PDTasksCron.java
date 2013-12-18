/*
 * OpenProdoc
 * 
 * See the help doc files distributed with
 * this work for additional information regarding copyright ownership.
 * Joaquin Hierro licenses this file to You under:
 * 
 * License GNU GPL v3 http://www.gnu.org/licenses/gpl.html
 * 
 * you may not use this file except in compliance with the License.  
 * Unless agreed to in writing, software is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * author: Joaquin Hierro      2011
 * 
 */

package prodoc;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jhierrot
 */
public class PDTasksCron extends PDTasksDef
{

public static final String fSTARTDATE="StartDate";
public static final String fNEXTDATE="NextDate";
public static final String fADDMONTH="AddMonth";
public static final String fADDDAYS="AddDays";
public static final String fADDHOURS="AddHours";
public static final String fADDMINS="AddMins";

/**
 *
 */
static private Record TaksTypeStruct=null;

/**
 *
 */
private Date StartDate;
private Date NextDate;
private int AddMonth=0;
private int AddDays=0;
private int AddHours=0;
private int AddMins=0;

static private ObjectsCache TaksDefObjectsCache = null;

//-------------------------------------------------------------------------
/**
 * 
 * @param Drv
 * @throws PDException
 */
public PDTasksCron(DriverGeneric Drv)  throws PDException
{
super(Drv);
}
//-------------------------------------------------------------------------
/**
 *
 * @param Rec
 * @throws PDException
 */
@Override
public void assignValues(Record Rec) throws PDException
{
super.assignValues(Rec);    
setStartDate((Date) Rec.getAttr(fSTARTDATE).getValue());
setNextDate((Date) Rec.getAttr(fNEXTDATE).getValue());
if (Rec.getAttr(fADDMONTH).getValue()==null)
    setAddMonth(0);
else
    setAddMonth((Integer) Rec.getAttr(fADDMONTH).getValue());
if (Rec.getAttr(fADDDAYS).getValue()==null)
    setAddDays(0);
else
    setAddDays((Integer) Rec.getAttr(fADDDAYS).getValue());
if (Rec.getAttr(fADDHOURS).getValue()==null)
    setAddHours(0);
else
    setAddHours((Integer) Rec.getAttr(fADDHOURS).getValue());
if (Rec.getAttr(fADDMINS).getValue()==null)
    setAddMins(0);
else
    setAddMins((Integer) Rec.getAttr(fADDMINS).getValue());
assignCommonValues(Rec);
}
//-------------------------------------------------------------------------
/**
 *
 * @return
 * @throws PDException
 */
@Override
synchronized public Record getRecord() throws PDException
{
Record Rec=getRecordStruct();
Rec.assign(super.getRecord().Copy());
Rec.getAttr(fSTARTDATE).setValue(getStartDate());
Rec.getAttr(fNEXTDATE).setValue(getNextDate());
Rec.getAttr(fADDMONTH).setValue(getAddMonth());
Rec.getAttr(fADDDAYS).setValue(getAddDays());
Rec.getAttr(fADDHOURS).setValue(getAddHours());
Rec.getAttr(fADDMINS).setValue(getAddMins());
getCommonValues(Rec);
return(Rec);
}
//-------------------------------------------------------------------------
/**
*
* @return
*/
@Override
public String getTabName()
{
return (getTableName());
}
//-------------------------------------------------------------------------

/**
*
* @return
*/
static public String getTableName()
{
return ("PD_TASKSDEFCRON");
}
//-------------------------------------------------------------------------
/**
*
* @return
*/
@Override
Record getRecordStruct() throws PDException
{
if (TaksTypeStruct==null)
    TaksTypeStruct=CreateRecordStruct();
return(TaksTypeStruct.Copy());
}
//-------------------------------------------------------------------------
/**
*
* @return
*/
static synchronized private Record CreateRecordStruct() throws PDException
{
if (TaksTypeStruct==null)
    {
    Record R=new Record();
    CreateRecordStructBase(R);
    R.addAttr( new Attribute(fSTARTDATE, fSTARTDATE, "Start Date of execution", Attribute.tDATE, true, null, 128, false, false, true));
    R.addAttr( new Attribute(fNEXTDATE, fNEXTDATE, "Next Date of execution", Attribute.tDATE, true, null, 128, false, false, true));
    R.addAttr( new Attribute(fADDMONTH, fADDMONTH, "Months to add for next execution", Attribute.tINTEGER, true, null, 128, false, false, true));
    R.addAttr( new Attribute(fADDDAYS, fADDDAYS, "Days to add for next execution", Attribute.tINTEGER, true, null, 128, false, false, true));
    R.addAttr( new Attribute(fADDHOURS, fADDHOURS, "Hours to add for next execution", Attribute.tINTEGER, true, null, 128, false, false, true));
    R.addAttr( new Attribute(fADDMINS, fADDMINS, "Mins to add for next execution", Attribute.tINTEGER, true, null, 128, false, false, true));
    return(R);
    }
else
    return(TaksTypeStruct);
}
//-------------------------------------------------------------------------
/**
* @return the StartDate
*/
public Date getStartDate()
{
return StartDate;
}
//-----------------------------------------------------------------------
/**
* @param StartDate the StartDate to set
*/
public void setStartDate(Date StartDate)
{
this.StartDate = StartDate;
}
//-----------------------------------------------------------------------
/**
* @return the NextDate
*/
public Date getNextDate()
{
return NextDate;
}
//-----------------------------------------------------------------------
/**
 * @param NextDate 
 */
public void setNextDate(Date NextDate)
{
this.NextDate = NextDate;
}
//-------------------------------------------------------------------------
/**
 * @return the AddMonth
 */
public int getAddMonth()
{
return AddMonth;
}
//-------------------------------------------------------------------------
/**
 * @param AddMonth the AddMonth to set
 */
public void setAddMonth(int AddMonth)
{
this.AddMonth = AddMonth;
}
//-------------------------------------------------------------------------
/**
 * @return the AddDays
 */
public int getAddDays()
{
return AddDays;
}
//-------------------------------------------------------------------------
/**
 * @param AddDays the AddDays to set
 */
public void setAddDays(int AddDays)
{
this.AddDays = AddDays;
}
//-------------------------------------------------------------------------
/**
 * @return the AddHours
 */
public int getAddHours()
{
return AddHours;
}
//-------------------------------------------------------------------------
/**
 * @param AddHours the AddHours to set
 */
public void setAddHours(int AddHours)
{
this.AddHours = AddHours;
}
//-------------------------------------------------------------------------
/**
 * @return the AddMins
 */
public int getAddMins()
{
return AddMins;
}
//-------------------------------------------------------------------------
/**
 * @param AddMins the AddMins to set
 */
public void setAddMins(int AddMins)
{
this.AddMins = AddMins;
}
//-------------------------------------------------------------------------
/**
* The install method is generic because for instantiate a object, the class
* need to access to the tables for definition
 * @param Drv
 * @throws PDException
*/
static protected void InstallMulti(DriverGeneric Drv) throws PDException
{
}
//-------------------------------------------------------------------------
/**
 * Create if necesary and Assign the Cache for the objects of this type of object
 * @return the cache object for the type
 */
 @Override
 protected ObjectsCache getObjCache()
{
if (TaksDefObjectsCache==null)
    TaksDefObjectsCache=new ObjectsCache("TasksDefCron");
return(TaksDefObjectsCache);    
}
//-------------------------------------------------------------------------

}
