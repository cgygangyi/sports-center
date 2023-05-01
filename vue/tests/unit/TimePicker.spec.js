import { shallowMount } from '@vue/test-utils';
import TimePicker from '@/components/Cards/TimePicker.vue';

describe('TimePicker.vue', () => {
    let wrapper;
    const sampleData = Array(40).fill().map((_, i) => ({
        id: i,
        open: 1,
        free: 1,
        begin: `2023-05-0${Math.floor(i / 10) + 1}T${(i % 10) + 9}:00:00`
    }));

    beforeEach(() => {
        wrapper = shallowMount(TimePicker, {
            propsData: {
                data: sampleData
            }
        });
    });

    it('renders the table with the correct number of rows and columns', () => {
        expect(wrapper.findAll('tr')).toHaveLength(11); // 1 header row + 10 data rows
        expect(wrapper.findAll('th')).toHaveLength(44); // 4 header columns + 4 columns in 10 rows
    });

    it('correctly formats and displays date strings in header', () => {
        const headerCells = wrapper.findAll('thead th');
        for (let i = 1; i < 5; i++) {
            expect(headerCells.at(i).text()).toBe(`2023.5.${i}`);
        }
    });

    it('calls isClick method when a table cell is clicked and changes chosen property accordingly', async () => {
        const isClickSpy = jest.spyOn(wrapper.vm, 'isClick');
        const tableCells = wrapper.findAll('th[id]');

        // Click on the first table cell
        await tableCells.at(0).trigger('click');
        expect(isClickSpy).toHaveBeenCalledWith(0);
        expect(wrapper.vm.chosen).toBe(0);

        // Click on the same table cell again
        await tableCells.at(0).trigger('click');
        expect(isClickSpy).toHaveBeenCalledWith(0);
        expect(wrapper.vm.chosen).toBe(-1);

        // Click on a different table cell
        await tableCells.at(1).trigger('click');
        expect(isClickSpy).toHaveBeenCalledWith(1);
        expect(wrapper.vm.chosen).toBe(1);
    });
});
