/*
 * generated by Xtext 2.12.0
 */
package polymorphic.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import polymorphic.csv.ui.internal.CsvActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class CsvExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return CsvActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return CsvActivator.getInstance().getInjector(CsvActivator.POLYMORPHIC_CSV);
	}
	
}
