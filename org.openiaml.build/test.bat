@rem set ECLIPSE_HOME=C:\eclipse-build
set ECLIPSE_HOME=C:\eclipse-33-2
@rem java -cp "%ECLIPSE_HOME%\plugins\org.eclipse.equinox.launcher_1.0.0.v20070606.jar" org.eclipse.core.launcher.Main -application org.openiaml.build.MyAntRunner -dev bin -consolelog -debug -Dcomponent=org.openiaml.build -Dconfigs="*,*,*" -Dbaseos=win32 -Dbasews=win32 -Dbasearch=x86 -Djavacfailonerror=true -Dpde.build.scripts=%ECLIPSE_HOME%/plugins/org.eclipse.pde.build_3.0.1/scripts -DbaseLocation=%ECLIPSE_HOME% -data "C:/Documents and Settings/jmwright.MASSEY/headless-build" -configuration "C:/Documents and Settings/jmwright.MASSEY/workspace-iaml/.metadata/.plugins/org.eclipse.pde.core/Eclipse Application/"
java -cp "%ECLIPSE_HOME%\plugins\org.eclipse.equinox.launcher_1.0.0.v20070606.jar" org.eclipse.core.launcher.Main -application org.openiaml.build.MyAntRunner2 -dev bin -consolelog -debug -Dcomponent=org.openiaml.build -Dconfigs="*,*,*" -Dbaseos=win32 -Dbasews=win32 -Dbasearch=x86 -Djavacfailonerror=true -Dpde.build.scripts=%ECLIPSE_HOME%/plugins/org.eclipse.pde.build_3.0.1/scripts -DbaseLocation=%ECLIPSE_HOME% -data "C:/Documents and Settings/jmwright.MASSEY/headless-build" -configuration "C:/Documents and Settings/jmwright.MASSEY/workspace-iaml/.metadata/.plugins/org.eclipse.pde.core/Eclipse Application/"