package nl.futureedge.sonar.plugin.packageanalyzer.metrics;

import static java.util.Arrays.asList;

import java.util.List;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

/**
 * Metrics definition.
 */
public final class PackageAnalyzerMetrics implements Metrics {

	/** Metric for package dependency cycles. */
	public static final Metric<Integer> PACKAGE_DEPENDENCY_CYCLES = new Metric.Builder("package-dependency-cycles",
			"Package dependency cycles", Metric.ValueType.INT).setDomain(CoreMetrics.DOMAIN_COMPLEXITY).create();
	/** Metric for package dependency cycle (identifier). */
	public static final Metric<String> PACKAGE_DEPENDENCY_CYCLES_IDENTIFIER = new Metric.Builder(
			"package-dependency-cycles-identifier", "Package dependency cycles (identifier)", Metric.ValueType.STRING)
					.setDomain(CoreMetrics.DOMAIN_COMPLEXITY).setHidden(true).create();
	/** Metric for package dependency cycle (identifiers). */
	public static final Metric<String> PACKAGE_DEPENDENCY_CYCLES_IDENTIFIERS = new Metric.Builder(
			"package-dependency-cycles-identifiers", "Package dependency cycles (identifiers)", Metric.ValueType.STRING)
					.setDomain(CoreMetrics.DOMAIN_COMPLEXITY).setHidden(true).create();

	@Override
	@SuppressWarnings("rawtypes")
	public List<Metric> getMetrics() {
		return asList(PACKAGE_DEPENDENCY_CYCLES, PACKAGE_DEPENDENCY_CYCLES_IDENTIFIER,
				PACKAGE_DEPENDENCY_CYCLES_IDENTIFIERS);
	}
}
