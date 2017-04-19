package nl.futureedge.sonar.plugin.packageanalyzer;

import org.sonar.api.Plugin;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

import nl.futureedge.sonar.plugin.packageanalyzer.metrics.PackageAnalyzerMetrics;
import nl.futureedge.sonar.plugin.packageanalyzer.rules.AbstractnessRule;
import nl.futureedge.sonar.plugin.packageanalyzer.rules.AfferentCouplingRule;
import nl.futureedge.sonar.plugin.packageanalyzer.rules.EfferentCouplingRule;
import nl.futureedge.sonar.plugin.packageanalyzer.rules.InstabilityRule;
import nl.futureedge.sonar.plugin.packageanalyzer.rules.JavaRules;
import nl.futureedge.sonar.plugin.packageanalyzer.rules.MissingPackageInfoRule;
import nl.futureedge.sonar.plugin.packageanalyzer.rules.NumberOfClassesAndInterfacesRule;
import nl.futureedge.sonar.plugin.packageanalyzer.rules.PackageDependencyCyclesRule;
import nl.futureedge.sonar.plugin.packageanalyzer.sensor.JavaSensor;

/**
 * Package analyzer plugin.
 */
public final class PackageAnalyzerPlugin implements Plugin {

	private static final Logger LOGGER = Loggers.get(PackageAnalyzerPlugin.class);
	
	public static final String KEY = "package-analyzer";

	@Override
	public void define(final Context context) {
		LOGGER.info("Defining plugin ...");
		
		// Rules
		context.addExtensions(AbstractnessRule.class,
				AfferentCouplingRule.class,
				EfferentCouplingRule.class,
				InstabilityRule.class,
				MissingPackageInfoRule.class,
				NumberOfClassesAndInterfacesRule.class,
				PackageDependencyCyclesRule.class);
		
		// Metrics
		context.addExtension(PackageAnalyzerMetrics.class);
		
		// Java
		context.addExtensions(JavaRules.class, JavaSensor.class);
	
		LOGGER.info("Plugin defined");
	}
}
