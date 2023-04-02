<template>

	<a-card :bordered="false" class="dashboard-bar-line header-solid">
		<template #title>
			<h6>Appointments Overview</h6>
			<p>than last year <span class="text-success">+20%</span></p>
		</template>
		<template #extra>
			<a-badge color="primary" class="badge-dot-primary" text="Basketball" />
			<a-badge color="primary" class="badge-dot-danger" text="Badminton" />
            <a-badge color="primary" class="badge-dot-secondary" text="Tennis" />
            <a-badge color="primary" class="badge-dot-success" text="Volleyball" />
		</template>
		<chart-line :height="310" :data="lineChartData"></chart-line>
	</a-card>

</template>

<script>

	// Bar chart for "Active Users" card.
	import ChartLine from '../Charts/ChartLine' ;

	export default ({
		components: {
			ChartLine,
		},
		data() {
			return {
				lineChartData: {
					labels: ["Oct", "Nov", "Dec", "Jan", "Feb", "Mar"],
					datasets: [{
						label: "Mobile apps",
						tension: 0.4,
						borderWidth: 0,
						pointRadius: 0,
						borderColor: "#1890FF",
						borderWidth: 3,
						data: [22, 50, 25, 40, 20, 50],
						maxBarThickness: 6

					},
					{
						label: "Websites",
						tension: 0.4,
						borderWidth: 0,
						pointRadius: 0,
						borderColor: "#B37FEB",
						borderWidth: 3,
						data: [63, 12, 13, 76, 37, 37],
						maxBarThickness: 6

					},
                    {
                        label: "Websites",
                        tension: 0.4,
                        borderWidth: 0,
                        pointRadius: 0,
                        borderColor: "green",
                        borderWidth: 3,
                        data: [14, 29, 29, 34, 23, 40],
                        maxBarThickness: 6

                    },
                    {
                        label: "Websites",
                        tension: 0.4,
                        borderWidth: 0,
                        pointRadius: 0,
                        borderColor: "red",
                        borderWidth: 3,
                        data: [21, 43, 13, 34, 23, 43],
                        maxBarThickness: 6

                    }],
				},
			}
		},
	})

</script>
