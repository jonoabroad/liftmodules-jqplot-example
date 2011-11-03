/*
        Copyright 2011 Spiral Arm Ltd

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.package bootstrap.liftmodules
*/
package bootstrap.liftweb  

import javax.servlet._ 
import javax.servlet.http._ 

import net.liftweb.http.LiftFilter 

//Based on http://groups.google.com/group/liftweb/browse_thread/thread/93f315f98641a63b/5149cd4b4efe49c2?lnk=gst&q=run+mode#5149cd4b4efe49c2
class CloudBeesLiftFilter extends LiftFilter { 
			
    private def run_mode_not_set_? = null == System.getProperty("run.mode")

    private def run_mode_from(config: FilterConfig) = Option(config.getServletContext.getInitParameter("run.mode"))

	override def init(config: FilterConfig) { 
		if (run_mode_not_set_?) {
			val mode = run_mode_from(config) getOrElse "development"
			println("Run mode set to: "+mode)
			System.setProperty("run.mode", mode)
		}
		super.init(config) 
	} 
} 