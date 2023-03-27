<template>

	<!-- Orders History Timeline Card -->
	<a-card :bordered="false" class="header-solid h-full" :bodyStyle="{paddingTop: '12px'}">
		<template #title>
			<h6>Announcements</h6>
		</template>
		<a-timeline pending="Recording..." :reverse="timelineReverse">
			<a-timeline-item color="green">
				The gym is closed today due to the weather
				<p>09 JUN 7:20 PM</p>
			</a-timeline-item>
			<a-timeline-item color="green">
                The gym is reopened
				<p>08 JUN 12:20 PM</p>
			</a-timeline-item>
			<a-timeline-item color="blue">
				Company server payments
				<p>04 JUN 3:10 PM</p>
			</a-timeline-item>
			<a-timeline-item color="blue">
                The gym is closed today due to the weather
				<p>02 JUN 2:45 PM</p>
			</a-timeline-item>
			<a-timeline-item color="blue">
				Unlock folders for development
				<p>18 MAY 1:30 PM</p>
			</a-timeline-item>
			<a-timeline-item color="gray">
				New order #46282344
				<p>14 MAY 3:30 PM</p>
			</a-timeline-item>
			<template #pendingDot> </template>
		</a-timeline>
	</a-card>
	<!-- / Orders History Timeline Card -->

</template>

<script>

	export default ({
		data() {
			return {

				// Whether or not the timeline in "Orders History" card is reversed.
				timelineReverse: false,
			}
		},
	})

</script>
