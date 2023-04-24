template>

	<!-- Active Users Card -->
	<a-card :bordered="false" class="dashboard-bar-chart">
		<chart-bar :height="220" :data="barChartData"></chart-bar>
		<div class="card-title">
			<h6>Active Clients</h6>
			<p>than last week <span class="text-success">+12%</span></p>
		</div>
		<div class="card-content">
			<p>We have created multiple options for you to put together and customise into pixel perfect pages.</p>
		</div>
		<a-row class="card-footer" type="flex" justify="center" align="top">
			<a-col :span="6">
				<h4>364</h4>
				<span>Users</span>
			</a-col>
			<a-col :span="6">
				<h4>2534</h4>
				<span>Clicks</span>
			</a-col>
		</a-row>
	</a-card>
	<!-- Active Users Card -->

</template>

<script>

	// Bar chart for "Active Users" card.
	import ChartBar from '../Charts/ChartBar' ;

	export default ({
		components: {
			ChartBar,
		},
		data() {
			return {
				// Data for bar chart.
				barChartData: {
					labels: ["01", "02", "03", "04", "05", "06"],
					datasets: [{
						label: "Sales",
						backgroundColor: '#fff',
						borderWidth: 0,
						borderSkipped: false,
						borderRadius: 6,
						data: [85, 60, 50, 62, 90, 50],
						maxBarThickness: 20,
					}, ],
				},
			}
		},
	})

</script>
